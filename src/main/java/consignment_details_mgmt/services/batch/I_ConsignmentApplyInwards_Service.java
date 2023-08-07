package consignment_details_mgmt.services.batch;

import java.util.concurrent.CompletableFuture;

public interface I_ConsignmentApplyInwards_Service {
	public CompletableFuture<Void> consignShippedItems();
}