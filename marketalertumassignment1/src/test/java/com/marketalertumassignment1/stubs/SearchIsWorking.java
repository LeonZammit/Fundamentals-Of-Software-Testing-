package com.marketalertumassignment1.stubs;

import com.marketalertumassignment1.Interfaces.CheckSearchManager;

public class SearchIsWorking implements CheckSearchManager {
    @Override
    public Boolean checkSearch() {
        return true;
    }
}
