package me.ultrusmods.originsjs;

import dev.latvian.mods.kubejs.event.EventJS;
import dev.latvian.mods.kubejs.script.ScriptType;
import io.github.apace100.origins.integration.OriginDataLoadedCallback;
import me.ultrusmods.originsjs.origins.OriginsJSActions;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OriginsJsMod implements ModInitializer {
	public static final String MOD_ID = "originsjs";
	public static final Logger LOGGER = LogManager.getLogger("templatemod");

	@Override
	public void onInitialize() {
		OriginsJSActions.register();
		OriginDataLoadedCallback.EVENT.register(isClient -> {
			if (!isClient) {
				new EventJS().post(ScriptType.SERVER, "origins.post_origin_load");
			} else {
				new EventJS().post(ScriptType.SERVER, "origins.post_origin_load_client");
			}
		});
	}
}
