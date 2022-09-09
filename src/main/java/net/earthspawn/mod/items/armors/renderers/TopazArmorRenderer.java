package net.earthspawn.mod.items.armors.renderers;

import net.earthspawn.mod.items.armors.classes.TopazArmorItem;
import net.earthspawn.mod.items.armors.models.TopazArmorModel;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class TopazArmorRenderer extends GeoArmorRenderer<TopazArmorItem> {
    public TopazArmorRenderer() {
        super(new TopazArmorModel());

        this.headBone = "helmet";
        this.bodyBone = "chestplate";
        this.rightArmBone = "rightArm";
        this.leftArmBone = "leftArm";
        this.rightLegBone = "rightLeg";
        this.leftLegBone = "leftLeg";
        this.rightBootBone = "rightBoot";
        this.leftBootBone = "leftBoot";
    }
}
