package com.airesnor.wuxiacraft.networking;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

import java.util.UUID;

public class EnergyMessage implements IMessage {

	public int op; // 0 -- add, 2 --rem, 3--set
	public float amount;
	public UUID senderUUID;

	public EnergyMessage(int op, float amount, UUID senderUUID) {
		this.op = op;
		this.amount = amount;
		this.senderUUID = senderUUID;
	}

	public EnergyMessage() {
		this.op = 0;
		this.amount = 0;
		this.senderUUID = null;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		PacketBuffer packetBuffer = new PacketBuffer(buf);
		this.op = buf.readInt();
		this.amount = buf.readFloat();
		this.senderUUID = packetBuffer.readUniqueId();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		PacketBuffer packetBuffer = new PacketBuffer(buf);
		buf.writeInt(this.op);
		buf.writeFloat(this.amount);
		packetBuffer.writeUniqueId(this.senderUUID);
	}
}
