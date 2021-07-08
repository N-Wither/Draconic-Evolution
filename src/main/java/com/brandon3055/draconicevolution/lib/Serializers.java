package com.brandon3055.draconicevolution.lib;

import com.brandon3055.brandonscore.api.TechLevel;
import com.brandon3055.draconicevolution.api.modules.Module;
import com.brandon3055.draconicevolution.init.DEModules;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.IDataSerializer;
import net.minecraft.util.Direction;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Optional;

/**
 * Created by brandon3055 on 15/4/21
 */
@Deprecated //These need to be registered to ForgeRegistries.DATA_SERIALIZERS
public class Serializers {

    public static final IDataSerializer<Optional<Module<?>>> OPT_MODULE_SERIALIZER = new IDataSerializer<Optional<Module<?>>>() {
        public void write(PacketBuffer buf, Optional<Module<?>> value) {
            buf.writeBoolean(value.isPresent());
            value.ifPresent(module -> buf.writeResourceLocation(module.getRegistryName()));
        }

        public Optional<Module<?>> read(PacketBuffer buf) {
            Module<?> module = DEModules.MODULE_REGISTRY.getValue(buf.readResourceLocation());
            return !buf.readBoolean() || module == null ? Optional.empty() : Optional.of(module);
        }

        public Optional<Module<?>> copy(Optional<Module<?>> value) {
            return value;
        }
    };

    public static final IDataSerializer<TechLevel> TECH_LEVEL_SERIALIZER = new IDataSerializer<TechLevel>() {
        public void write(PacketBuffer packetBuffer, TechLevel techLevel) {
            packetBuffer.writeEnum(techLevel);
        }

        public TechLevel read(PacketBuffer packetBuffer) {
            return packetBuffer.readEnum(TechLevel.class);
        }

        public TechLevel copy(TechLevel techLevel) {
            return techLevel;
        }
    };

    static {
//        DataSerializers.registerSerializer(OPT_MODULE_SERIALIZER);
//        DataSerializers.registerSerializer(TECH_LEVEL_SERIALIZER);
    }

}
