package com.marketalertumassignment1.stubs;

import com.marketalertumassignment1.Interfaces.CheckResultManager;

public class ResultIsFound implements CheckResultManager {
    @Override
    public Boolean checkResult() {
        return true;
    }
}
