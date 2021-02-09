package org.dndm.init.screen;

import org.dndm.common.BaseController;

public class Controller extends BaseController {

    public void onInitNewCampaign() {
        sceneManager.switchScene("/dndm/campaign_setup_wizard/campaignWizardView.fxml", 800d, 600d);
    }

    public void onLoadCampaign() {
       sceneManager.switchScene("/dndm/load_campaign_view/loadCampaignView.fxml", 800d, 600d);
    }
}
