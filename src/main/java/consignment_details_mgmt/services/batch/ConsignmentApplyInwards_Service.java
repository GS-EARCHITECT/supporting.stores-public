package consignment_details_mgmt.services.batch;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import consignment_details_mgmt.model.master.ConsignmentDetail;
import consignment_details_mgmt.model.repo.cud.ConsignmentDetailsCUD_Repo;
import consignment_details_mgmt.model.repo.read.ConsignmentDetailsRead_Repo;
import consignment_master_mgmt.model.master.ConsignmentMaster;
import consignment_master_mgmt.model.repo.cud.ConsignmentMasterCUD_Repo;
import consignment_master_mgmt.model.repo.read.ConsignmentMasterRead_Repo;
import store_order_outwards_mgmt.model.repo.read.StoreOrderOutwardsRead_Repo;
import store_stock_movement_mgmt.recieve.model.master.StoreRecieveMaster;
import store_stock_movement_mgmt.recieve.model.repo.cud.StoreRecieveMasterCUD_Repo;
import store_stock_movement_mgmt.recieve.model.repo.read.StoreRecieveMasterRead_Repo;

@Service("consignmentApplyInwardsServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ConsignmentApplyInwards_Service implements I_ConsignmentApplyInwards_Service
{

	// private static final Logger logger =
	// LoggerFactory.getLogger(ConsignmentDetailService.class);

	@Autowired
	private StoreRecieveMasterCUD_Repo storeRecieveMasterCUDRepo;
	
	@Autowired
	private ConsignmentMasterCUD_Repo consignmentMasterCUDRepo;
	
	@Autowired
	private ConsignmentMasterRead_Repo consignmentMasterReadRepo;
	
	@Autowired
	private ConsignmentDetailsCUD_Repo consignmentDetailsCUDRepo;	

	@Autowired
	private ConsignmentDetailsRead_Repo consignmentDetailsReadRepo;
	
	@Autowired
	private StoreOrderOutwardsRead_Repo storeOrderOutwardsReadRepo;
	
	@Autowired
	private StoreRecieveMasterRead_Repo storeRecieveMasterReadRepo;
	
	@Autowired
	private Executor asyncExecutor;

	@Override
	@Scheduled(fixedRate=3000)
	public CompletableFuture<Void> consignShippedItems()
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> 
		{
			CopyOnWriteArrayList<ConsignmentMaster> consignmentMasters = consignmentMasterReadRepo.getSelectConsignmentInMastersPending();
			CopyOnWriteArrayList<ConsignmentDetail> rConsignmentDetails = null; 
			ConsignmentMaster consignmentMaster = null;			
			StoreRecieveMaster storeRecieveMaster = null;
			Long mNo = (long) 0;
			Long cNo = (long) 0;
			Long rNo = (long) 0;
			Float qty = (float) 0;			
			
			for (int i = 0; i < consignmentMasters.size(); i++) 
			{
			consignmentMaster = consignmentMasters.get(i);
			rConsignmentDetails = consignmentDetailsReadRepo.getSelectConsignmentResourceDetailsPending(consignmentMaster.getConsignmentSeqNo()); 
			cNo = consignmentMaster.getConsignmentSeqNo();
			
			for (int j = 0; j < rConsignmentDetails.size(); j++) 
			{
			qty = rConsignmentDetails.get(j).getQty();
			rNo = rConsignmentDetails.get(j).getResourceSeqNo();			
			storeRecieveMaster = new StoreRecieveMaster();
			storeRecieveMaster.setConsignQty(qty);
			storeRecieveMaster.setResourceSeqNo(rNo);
			mNo = storeRecieveMasterCUDRepo.save(storeRecieveMaster).getStoreMovementSeqNo();
			consignmentDetailsCUDRepo.updConsignmentMasterMovementNoForResource(mNo, cNo, rNo, qty);
			}
			}			
	return;
}, asyncExecutor);
return future;
}

}