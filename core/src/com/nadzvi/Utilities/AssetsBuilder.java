package com.nadzvi.Utilities;

/**
 * Created by Xato on 10/7/2014.
 */
public class AssetsBuilder {
    public static AssetsAPI buildAssets(){
        return new TryCatchAssets();
    }
}
