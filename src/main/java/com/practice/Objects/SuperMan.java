package com.practice.Objects;

import com.practice.study.reflect.ActionInterface;

/**
 * Created by junwuguo on 2017/2/13 0013.
 */
public class SuperMan extends Person implements ActionInterface {

    private boolean blueBriefs;

    public void fly() {
        System.out.println("���˻��Ү����");
    }

    public boolean isBlueBriefs() {
        return blueBriefs;
    }

    public void setBlueBriefs(boolean blueBriefs) {
        this.blueBriefs = blueBriefs;
    }

    @Override
    public void walk(int m) {
        System.out.println("���˻���Ү��������" + m + "�׾��߲����ˣ�");
    }

}
