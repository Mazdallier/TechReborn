package techreborn.compat.nei.recipes;

import codechicken.nei.PositionedStack;
import net.minecraft.client.gui.inventory.GuiContainer;
import techreborn.api.recipe.IBaseRecipeType;
import techreborn.client.gui.GuiLathe;
import techreborn.util.ItemUtils;

import java.util.List;

public class LatheRecipeHandler extends GenericRecipeHander implements INeiBaseRecipe {
    @Override
    public void addPositionedStacks(List<PositionedStack> input, List<PositionedStack> outputs, IBaseRecipeType recipeType) {
        int offset = 4;
        if (recipeType.getInputs().size() > 0) {
            PositionedStack pStack = new PositionedStack(ItemUtils.getStackWithAllOre(recipeType.getInputs().get(0)), 56 - offset, 17 - offset);
            input.add(pStack);
        }

        if (recipeType.getOutputs().size() > 0) {
            PositionedStack pStack3 = new PositionedStack(recipeType.getOutputs().get(0), 116 - offset, 35 - offset);
            outputs.add(pStack3);
        }
    }

    @Override
    public String getRecipeName() {
        return "latheRecipe";
    }

    @Override
    public String getGuiTexture() {
        return "techreborn:textures/gui/lathe.png";
    }

    @Override
    public Class<? extends GuiContainer> getGuiClass() {
        return GuiLathe.class;
    }

    @Override
    public INeiBaseRecipe getNeiBaseRecipe() {
        return this;
    }
}
