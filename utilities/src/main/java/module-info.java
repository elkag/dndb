module dndm.utilities {

    requires java.sql;
    requires org.slf4j;

    requires com.zaxxer.hikari;
    exports dndm.utilities.db;
    exports dndm.utilities.db.anotations;
}