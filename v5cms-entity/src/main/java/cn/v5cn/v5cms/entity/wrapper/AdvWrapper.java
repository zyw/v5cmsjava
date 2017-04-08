package cn.v5cn.v5cms.entity.wrapper;

import cn.v5cn.v5cms.entity.Adv;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by ZYW on 2014/7/28.
 */
public class AdvWrapper implements Serializable {
    private Adv adv;
    private Map<String,Object> ati;

    public Adv getAdv() {
        return adv;
    }

    public void setAdv(Adv adv) {
        this.adv = adv;
    }
    public Map<String, Object> getAti() {
        return ati;
    }

    public void setAti(Map<String, Object> ati) {
        this.ati = ati;
    }

    @Override
    public String toString() {
        return "AdvWrapper{" +
                "adv=" + adv +
                ", ati=" + ati +
                '}';
    }
}
