package com.application.server.service;

import java.util.List;
import java.util.function.BiConsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.server.data.entity.Pornstar;

public class ServiceAsync {

	// ***********************************************************************************************************
	// Section de code : Variables
	// ***********************************************************************************************************

	private final Logger logger = LoggerFactory.getLogger(ServiceAsync.class);

	private static PornstarService pornstarService;

	// ***********************************************************************************************************
	// Section de code : Méthodes
	// ***********************************************************************************************************

	public static void getPornstarList(BiConsumer<List<Pornstar>, Throwable> consumer) {
		// TODO JT : TEST
		// CompletableFuture.supplyAsync(() -> BinanceService.getBinanceTicker(cp))
		// .whenComplete((i, j) -> consumer.accept(i, j));
	}

	// ***********************************************************************************************************
	// Section de code : Accesseurs
	// ***********************************************************************************************************

	// TODO JT : TEST
	// public static PornstarService getPornstarService() {
	// if (pornstarService == null) {
	// pornstarService = new PornstarService(new );
	// }
	//
	// return pornstarService;
	// }

}
