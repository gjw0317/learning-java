package com.practice.study.server;

import java.util.List;

/**
 * Created by junwuguo on 2017/2/21 0021.
 */
public class DeploymentOverview {
    private List<Integer> autoDeploy;
    private List<Integer> onlineNumber;

    public List<Integer> getAutoDeploy() {
        return autoDeploy;
    }

    public void setAutoDeploy(List<Integer> autoDeploy) {
        this.autoDeploy = autoDeploy;
    }

    public List<Integer> getOnlineNumber() {
        return onlineNumber;
    }

    public void setOnlineNumber(List<Integer> onlineNumber) {
        this.onlineNumber = onlineNumber;
    }
}
