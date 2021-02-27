package dndm.app.base.injection;

import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.util.Callback;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class DependencyInjection {

    /**
     * A map of all ViewsConfig that can be injected, and the methods responsible for doing so.
     */
    private static final Map<Class<?>, Callback<Class<?>, Object>> injectionMethods = new HashMap<>();
    private static ResourceBundle bundle = null;

    public static void setBundle(ResourceBundle bundle) {
        DependencyInjection.bundle = bundle;
    }

    public static Node load(String location) throws IOException {
        FXMLLoader loader = getLoader(location);
        return loader.load();
    }

    public static FXMLLoader getLoader(String location) {
        return new FXMLLoader(
                DependencyInjection.class.getResource(location),
                bundle,
                new JavaFXBuilderFactory(),
                DependencyInjection::constructController);
    }

    /**
     * Determine whether a stored method is available
     * If one is, return the custom controller
     * If one is not, return the default controller
     * @param controllerClass the class of controller to be created
     * @return the controller created
     */
    private static Object constructController(Class<?> controllerClass) {
        if(injectionMethods.containsKey(controllerClass)) {
            return loadControllerWithSavedMethod(controllerClass);
        } else {
            return loadControllerWithDefaultConstructor(controllerClass);
        }
    }

    /**
     * Load a controller using the saved method
     * @param controller the class of the controller to be loaded
     * @return the loaded controller
     */
    private static Object loadControllerWithSavedMethod(Class<?> controller){
        try {
            return injectionMethods.get(controller).call(Object.class);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    private static Object loadControllerWithDefaultConstructor(Class<?> controller){
        try {
            return controller.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new IllegalStateException(e);
        }
    }

    public static void addInjectionMethod(Class<?> controller, Callback<Class<?>, Object> method){
        injectionMethods.put(controller, method);
    }

    public static void removeInjectionMethod(Class<?> controller){
        injectionMethods.remove(controller);
    }
}