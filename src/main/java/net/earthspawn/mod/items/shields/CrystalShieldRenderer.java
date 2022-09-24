package net.earthspawn.mod.items.shields;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class CrystalShieldRenderer extends GeoItemRenderer<CrystalShieldItem> {
    public CrystalShieldRenderer() {
        super(new CrystalShieldModel());
    }
}
