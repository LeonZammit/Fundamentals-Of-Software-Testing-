package com.marketalertumassignment1.stubs;

import com.marketalertumassignment1.Interfaces.CheckSearchManager;

public class SearchIsNotWorking implements CheckSearchManager {

    @Override
    public Boolean checkSearch() {
        return false;
    }
}
