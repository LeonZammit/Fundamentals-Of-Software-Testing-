package com.marketalertumassignment1.stubs;

import com.marketalertumassignment1.Interfaces.CheckResultManager;

public class ResultIsNotFound implements CheckResultManager {
    @Override
    public Boolean checkResult() {
        return false;
    }
}
