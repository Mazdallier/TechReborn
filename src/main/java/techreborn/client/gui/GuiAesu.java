package techreborn.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import techreborn.client.container.ContainerAesu;
import techreborn.tiles.TileAesu;

public class GuiAesu extends GuiContainer {

	private static final ResourceLocation texture = new ResourceLocation(
			"techreborn", "textures/gui/aesu.png");

	TileAesu aesu;

	public GuiAesu(EntityPlayer player,
			TileAesu tileaesu)
	{
		super(new ContainerAesu(tileaesu, player));
		this.xSize = 176;
		this.ySize = 167;
		aesu = tileaesu;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_,
			int p_146976_2_, int p_146976_3_)
	{
		this.mc.getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
	}

	protected void drawGuiContainerForegroundLayer(int p_146979_1_,
			int p_146979_2_)
	{
		this.fontRendererObj.drawString(StatCollector.translateToLocal("tile.techreborn.aesu.name"), 40, 6, 4210752);
	}
}
