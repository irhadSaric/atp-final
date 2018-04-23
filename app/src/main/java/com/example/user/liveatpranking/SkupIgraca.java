package com.example.user.liveatpranking;

import java.util.ArrayList;

/**
 * Created by User on 4/23/2018.
 */

public class SkupIgraca {
    public ArrayList<Igrac> igraci;

    public SkupIgraca(ArrayList<Igrac> igraci) {
        this.igraci = igraci;
    }

    public ArrayList<Igrac> getIgraci() {
        return igraci;
    }

    public void setIgraci(ArrayList<Igrac> igraci) {
        this.igraci = igraci;
    }
}
