package techreborn.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import techreborn.client.container.ContainerAssemblingMachine;
import techreborn.tiles.TileAssemblingMachine;

public class GuiAssemblingMachine extends GuiContainer {

	private static final ResourceLocation texture = new ResourceLocation("techreborn", "textures/gui/assembling_machine.png");

	TileAssemblingMachine assemblingmachine;

	public GuiAssemblingMachine(EntityPlayer player, TileAssemblingMachine tileassemblinmachine) {
		super(new ContainerAssemblingMachine(tileassemblinmachine, player));
		this.xSize = 176;
		this.ySize = 167;
		assemblingmachine = tileassemblinmachine;
	}
	
    @Override
    public void initGui() {
        this.buttonList.clear();
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.buttonList.add(new GuiButton(0, k + 4,  l + 4, 20, 20, "R"));
        super.initGui();
    }

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
		this.mc.getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);

		int j = 0;

		if(assemblingmachine.crafter.currentRecipe != null) {
			j = this.assemblingmachine.crafter.currentTickTime * 20 / this.assemblingmachine.crafter.currentRecipe.tickTime();
		}
        this.drawTexturedModalRect(k + 86, l + 34, 176, 14, j + 1, 16);

		j = (int)this.assemblingmachine.energy.getEnergyStored() * 12 / this.assemblingmachine.energy.getCapacity();
		if(j > 0) {
            this.drawTexturedModalRect(k + 56, l + 36 + 12 - j, 176, 12 - j, 14, j + 2);
		}
	}

	protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
		String name = StatCollector.translateToLocal("tile.techreborn.assemblinmachine.name");
		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
	}
}
