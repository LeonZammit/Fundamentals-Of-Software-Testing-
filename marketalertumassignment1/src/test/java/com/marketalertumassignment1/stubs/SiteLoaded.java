package com.marketalertumassignment1.stubs;

import com.marketalertumassignment1.Interfaces.CheckLoadManager;

public class SiteLoaded implements CheckLoadManager {

    @Override
    public Boolean checkSiteTitle() {
        return true;
    }
}
