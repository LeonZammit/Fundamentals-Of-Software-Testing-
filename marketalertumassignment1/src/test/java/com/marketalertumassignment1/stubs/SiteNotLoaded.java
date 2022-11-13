package com.marketalertumassignment1.stubs;

import com.marketalertumassignment1.Interfaces.CheckLoadManager;

public class SiteNotLoaded implements CheckLoadManager {

    @Override
    public Boolean checkSiteTitle() {
        return false;
    }
}
