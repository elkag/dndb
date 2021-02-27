package dndm.app.base;


public enum ViewsConfig {
    INITIAL_SCREEN("/dndm/start_view/initialScreenView.fxml", 600, 400),
    LOAD_CAMPAIGN("/dndm/load_campaign_views/loadCampaignView.fxml", 1000, 800),
    SETTLEMENTS_TREE("/dndm/campaign_setup_wizard_views/settlements/settlementsMap.fxml", 1000, 800),
    SETTLEMENTS_LIST("/dndm/campaign_setup_wizard_views/settlements/settlementsList.fxml", 1000, 800),
    MERCHANTS_LIST("/dndm/campaign_setup_wizard_views/merchants/merchantList.fxml", 1000, 800),
    MERCHANT_VIEW("/dndm/campaign_setup_wizard_views/merchants/merchant.fxml"),
    ITEMS_LIST("/dndm/campaign_setup_wizard_views/items/itemsList.fxml", 1000, 800),
    ADD_ITEMS("/dndm/setup/items/test.fxml", 800, 600);

    private final String url;
    private double width;
    private double height;

    public String getUrl() {
        return url;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    ViewsConfig(String url, double width, double height) {
        this.url = url;
        this.width = width;
        this.height = height;
    }

    ViewsConfig(String url) {
        this.url = url;
    }
}
