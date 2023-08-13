package store_order_asset_inwards_mgmt.services.read;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import store_order_asset_inwards_mgmt.model.dto.StoreOrderAssetInward_DTO;
import store_order_asset_inwards_mgmt.model.master.StoreOrderAssetInward;
import store_order_asset_inwards_mgmt.model.repo.read.StoreOrderAssetInwardsReadPublic_Repo;

@Service("storeOrderAssetInwardsReadPublicServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class StoreOrderAssetInwardsReadPublic_Service implements I_StoreOrderAssetInwardsReadPublic_Service 
{

//	private static final Logger logger = LoggerFactory.getLogger(StoreOrderAssetInwardService.class);

	@Autowired
	private StoreOrderAssetInwardsReadPublic_Repo storeOrderAssetInwardsReadPublicRepo;
	
	@Autowired
	private Executor asyncExecutor;
			
	@Override
	public CompletableFuture<CopyOnWriteArrayList<StoreOrderAssetInward_DTO>> getAllStoreInwards()  
	{
		CompletableFuture<CopyOnWriteArrayList<StoreOrderAssetInward_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<StoreOrderAssetInward> stoList = (CopyOnWriteArrayList<StoreOrderAssetInward>) storeOrderAssetInwardsReadPublicRepo.findAll();
		CopyOnWriteArrayList<StoreOrderAssetInward_DTO> stoDTOs = new CopyOnWriteArrayList<StoreOrderAssetInward_DTO>();
		stoDTOs = stoList != null ? this.getStoreOrderAssetInward_DTOs(stoList) : null;
		return stoDTOs;
		},asyncExecutor);

	return future;

	}
	
	@Override
	public CompletableFuture<CopyOnWriteArrayList<StoreOrderAssetInward_DTO>> getSelectOrderInwards( CopyOnWriteArrayList<Long> sids)  
	{
		CompletableFuture<CopyOnWriteArrayList<StoreOrderAssetInward_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<StoreOrderAssetInward> stoList = (CopyOnWriteArrayList<StoreOrderAssetInward>) storeOrderAssetInwardsReadPublicRepo.findAllById(sids);
		CopyOnWriteArrayList<StoreOrderAssetInward_DTO> stoDTOs = new CopyOnWriteArrayList<StoreOrderAssetInward_DTO>();
		stoDTOs = stoList != null ? this.getStoreOrderAssetInward_DTOs(stoList) : null;
		return stoDTOs;
		},asyncExecutor);

	return future;

	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<StoreOrderAssetInward_DTO>> getAllRowsForMode( Short mode)  
	{
		CompletableFuture<CopyOnWriteArrayList<StoreOrderAssetInward_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<StoreOrderAssetInward> stoList = (CopyOnWriteArrayList<StoreOrderAssetInward>) storeOrderAssetInwardsReadPublicRepo.getAllRowsForMode(mode);
		CopyOnWriteArrayList<StoreOrderAssetInward_DTO> stoDTOs = new CopyOnWriteArrayList<StoreOrderAssetInward_DTO>();
		stoDTOs = stoList != null ? this.getStoreOrderAssetInward_DTOs(stoList) : null;
		return stoDTOs;
		},asyncExecutor);

	return future;

	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<Long>> getAllSeqNosForMode( Long mode)  
	{
		CompletableFuture<CopyOnWriteArrayList<Long>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<Long> stoList = storeOrderAssetInwardsReadPublicRepo.getAllSeqNosForMode(mode);
		return stoList;
		},asyncExecutor);

	return future;

	}
	
	@Override
	public CompletableFuture<Character> getIsbookedStatus( Long storeReqSeqNo)  
	{
		CompletableFuture<Character> future = CompletableFuture.supplyAsync(() -> 
		{
		Character st = storeOrderAssetInwardsReadPublicRepo.getIsbookedStatus(storeReqSeqNo);
		return st;
		},asyncExecutor);

	return future;

	}
	
	@Override
	public CompletableFuture<Character> getIsDoneStatus( Long storeReqSeqNo)  
	{
		CompletableFuture<Character> future = CompletableFuture.supplyAsync(() -> 
		{
		Character st = storeOrderAssetInwardsReadPublicRepo.getIsDoneStatus(storeReqSeqNo);
		return st;
		},asyncExecutor);

	return future;

	}

	@Override
	public CompletableFuture<Character> getIsOkStatus( Long storeReqSeqNo)  
	{
		CompletableFuture<Character> future = CompletableFuture.supplyAsync(() -> 
		{
		Character st = storeOrderAssetInwardsReadPublicRepo.getIsOkStatus(storeReqSeqNo);
		return st;
		},asyncExecutor);

	return future;

	}
	
	public CompletableFuture<Float> getOrderRequestedFlag( Long storeReqSeqNo)
	{
		CompletableFuture<Float> future = CompletableFuture.supplyAsync(() -> 
		{
		Float result = storeOrderAssetInwardsReadPublicRepo.getOrderRequestedFlag(storeReqSeqNo);
		return result;
		},asyncExecutor);

	return future;

	}	
	
	public CompletableFuture<Float> getCountRequestedForJob( Long jobWorkSeqNo,  Long assetSeqNo,  Short mode)
	{
		CompletableFuture<Float> future = CompletableFuture.supplyAsync(() -> 
		{
		Float result = storeOrderAssetInwardsReadPublicRepo.getCountRequestedForJob( jobWorkSeqNo,  assetSeqNo,  mode);
		return result;
		},asyncExecutor);

	return future;

	}	

	public CompletableFuture<Float> getCountRequestedBeforeThisRequest( Long storeReqSeqNo,  Long assetSeqNo,  Short mode)
	{
		CompletableFuture<Float> future = CompletableFuture.supplyAsync(() -> 
		{
		Float result = storeOrderAssetInwardsReadPublicRepo.getCountRequestedBeforeThisRequest( storeReqSeqNo,  assetSeqNo,  mode);
		return result;
		},asyncExecutor);

	return future;

	}	

	public CompletableFuture<Float> getCountRequestedBeforeDTTM( String dTTm,  Long assetSeqNo,  Short mode)
	{
		CompletableFuture<Float> future = CompletableFuture.supplyAsync(() -> 
		{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime rd = LocalDateTime.parse(dTTm, formatter);
		Timestamp dTTs = Timestamp.valueOf(rd);
		Float result = storeOrderAssetInwardsReadPublicRepo.getCountRequestedBeforeDTTM( dTTs,  assetSeqNo,  mode);
		return result;
		},asyncExecutor);

	return future;

	}
	
	public CompletableFuture<Float>	getOrderAllocatedFlag( Long storeReqSeqNo)
	{
		CompletableFuture<Float> future = CompletableFuture.supplyAsync(() -> 
		{
		Float result = storeOrderAssetInwardsReadPublicRepo.getOrderAllocatedFlag( storeReqSeqNo);
		return result;
		},asyncExecutor);

	return future;

	}
	
	public CompletableFuture<Float> getCountAllocatedForJob( Long jobWorkSeqNo,  Long assetSeqNo,  Short mode)
	{
		CompletableFuture<Float> future = CompletableFuture.supplyAsync(() -> 
		{
		Float result = storeOrderAssetInwardsReadPublicRepo.getCountAllocatedForJob( jobWorkSeqNo,  assetSeqNo,  mode);
		return result;
		},asyncExecutor);

	return future;

	}	

	public CompletableFuture<Float> getCountAllocatedBeforeThisRequest( Long storeReqSeqNo,  Long assetSeqNo,  Short mode)
	{
		CompletableFuture<Float> future = CompletableFuture.supplyAsync(() -> 
		{
		Float result = storeOrderAssetInwardsReadPublicRepo.getCountAllocatedBeforeThisRequest( storeReqSeqNo,  assetSeqNo,  mode);
		return result;
		},asyncExecutor);

	return future;

	}	


	public CompletableFuture<Float> getCountAllocatedBeforeDTTM( String dTTm,  Long assetSeqNo,  Short mode)
	{
		CompletableFuture<Float> future = CompletableFuture.supplyAsync(() -> 
		{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime rd = LocalDateTime.parse(dTTm, formatter);
		Timestamp dTTs = Timestamp.valueOf(rd);
		Float result = storeOrderAssetInwardsReadPublicRepo.getCountAllocatedBeforeDTTM( dTTs,  assetSeqNo,  mode);
		return result;
		},asyncExecutor);

	return future;

	}	


	public CompletableFuture<Float> getOrderBookedFlag( Long storeReqSeqNo)
	{
		CompletableFuture<Float> future = CompletableFuture.supplyAsync(() -> 
		{
		Float result = storeOrderAssetInwardsReadPublicRepo.getOrderBookedFlag( storeReqSeqNo);
		return result;
		},asyncExecutor);

	return future;

	}

	
	public CompletableFuture<Float> getCountBookedForJob( Long jobWorkSeqNo,  Long assetSeqNo,  Short mode)
	{
		CompletableFuture<Float> future = CompletableFuture.supplyAsync(() -> 
		{
		Float result = storeOrderAssetInwardsReadPublicRepo.getCountBookedForJob( jobWorkSeqNo,  assetSeqNo,  mode);
		return result;
		},asyncExecutor);

	return future;

	}	

	public CompletableFuture<Float> getCountBookedBeforeThisRequest( Long storeReqSeqNo,  Long assetSeqNo,  Short mode)
	{
		CompletableFuture<Float> future = CompletableFuture.supplyAsync(() -> 
		{
		Float result = storeOrderAssetInwardsReadPublicRepo.getCountBookedBeforeThisRequest( storeReqSeqNo,  assetSeqNo,  mode);
		return result;
		},asyncExecutor);

	return future;

	}	


	public CompletableFuture<Float> getCountBookedBeforeDTTM( String dTTm,  Long assetSeqNo,  Short mode)
	{
		CompletableFuture<Float> future = CompletableFuture.supplyAsync(() -> 
		{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime rd = LocalDateTime.parse(dTTm, formatter);
		Timestamp dTTs = Timestamp.valueOf(rd);
		Float result = storeOrderAssetInwardsReadPublicRepo.getCountBookedBeforeDTTM( dTTs,  assetSeqNo,  mode);
		return result;
		},asyncExecutor);

	return future;

	}	

	
	public CompletableFuture<Float> getOrderMovedFlag( Long storeReqSeqNo)
	{
		CompletableFuture<Float> future = CompletableFuture.supplyAsync(() -> 
		{
		Float result = storeOrderAssetInwardsReadPublicRepo.getOrderMovedFlag( storeReqSeqNo);
		return result;
		},asyncExecutor);

	return future;

	}

	public CompletableFuture<Float> getCountMovedForJob( Long jobWorkSeqNo,  Long assetSeqNo, Short md)
	{
		CompletableFuture<Float> future = CompletableFuture.supplyAsync(() -> 
		{
		Float result = storeOrderAssetInwardsReadPublicRepo.getCountMovedForJob( jobWorkSeqNo,  assetSeqNo, md);
		return result;
		},asyncExecutor);

	return future;

	}
	
	public CompletableFuture<Float> getCountMovedBeforeThisRequest( Long storeReqSeqNo,  Long assetSeqNo,  Short mode)
	{
		CompletableFuture<Float> future = CompletableFuture.supplyAsync(() -> 
		{
		Float result = storeOrderAssetInwardsReadPublicRepo.getCountMovedBeforeThisRequest( storeReqSeqNo,  assetSeqNo,  mode);
		return result;
		},asyncExecutor);

	return future;

	}
	
	public CompletableFuture<Float> getCountMovedBeforeDTTM( String dTTm,  Long assetSeqNo,  Short mode)
	{
		CompletableFuture<Float> future = CompletableFuture.supplyAsync(() -> 
		{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime rd = LocalDateTime.parse(dTTm, formatter);
		Timestamp dTTs = Timestamp.valueOf(rd);
		Float result = storeOrderAssetInwardsReadPublicRepo.getCountMovedBeforeDTTM(dTTs, assetSeqNo, mode);
		return result;
		},asyncExecutor);

	return future;

	}	

	public CompletableFuture<Float> getTotalRowsForAssetsBeforeThisDTTM( String dTTm,  Long assetSeqNo, Short mode)
	{
		CompletableFuture<Float> future = CompletableFuture.supplyAsync(() -> 
		{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime rd = LocalDateTime.parse(dTTm, formatter);
		Timestamp dTTs = Timestamp.valueOf(rd);
		Float result = storeOrderAssetInwardsReadPublicRepo.	getTotalRowsForAssetsBeforeThisDTTM( dTTs,  assetSeqNo,  mode);
		return result;
		},asyncExecutor);

	return future;

	}	

	public CompletableFuture<Float> getTotalRowCount()
	{
		CompletableFuture<Float> future = CompletableFuture.supplyAsync(() -> 
		{
		Float result = storeOrderAssetInwardsReadPublicRepo.getTotalRowCount();
		return result;
		},asyncExecutor);

	return future;

	}	

	
	private synchronized CopyOnWriteArrayList<StoreOrderAssetInward_DTO> getStoreOrderAssetInward_DTOs(CopyOnWriteArrayList<StoreOrderAssetInward> stoMasters) {
		StoreOrderAssetInward_DTO stoDTO = null;
		CopyOnWriteArrayList<StoreOrderAssetInward_DTO> stoDTOs = new CopyOnWriteArrayList<StoreOrderAssetInward_DTO>();

		for (int i = 0; i < stoMasters.size(); i++) {
			stoDTO = getStoreOrderAssetInward_DTO(stoMasters.get(i));
			stoDTOs.add(stoDTO);
		}
		return stoDTOs;
	}

	private synchronized StoreOrderAssetInward_DTO getStoreOrderAssetInward_DTO(StoreOrderAssetInward storeOrderAssetInward) 
	{
		StoreOrderAssetInward_DTO storeOrderAssetInward_DTO = new StoreOrderAssetInward_DTO();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		storeOrderAssetInward_DTO.setDoneflag(storeOrderAssetInward.getDoneflag());
		storeOrderAssetInward_DTO.setFromDttm(formatter.format(storeOrderAssetInward.getFromDttm().toLocalDateTime()));
		storeOrderAssetInward_DTO.setToDttm(formatter.format(storeOrderAssetInward.getToDttm().toLocalDateTime()));
		storeOrderAssetInward_DTO.setIsBooked(storeOrderAssetInward.getIsBooked());
		storeOrderAssetInward_DTO.setJobWorkSeqNo(storeOrderAssetInward.getJobWorkSeqNo());		
		storeOrderAssetInward_DTO.setLocationSeqNo(storeOrderAssetInward.getLocationSeqNo());
		storeOrderAssetInward_DTO.setModeTxn(storeOrderAssetInward.getModeTxn());
		storeOrderAssetInward_DTO.setMovedFlag(storeOrderAssetInward.getMovedFlag());
		storeOrderAssetInward_DTO.setOkflag(storeOrderAssetInward.getOkflag());
		storeOrderAssetInward_DTO.setFlagAllocated(storeOrderAssetInward.getFlagAllocated());
		storeOrderAssetInward_DTO.setFlagBooked(storeOrderAssetInward.getFlagBooked());
		storeOrderAssetInward_DTO.setFlagRequested(storeOrderAssetInward.getFlagRequested());
		storeOrderAssetInward_DTO.setRequestedToPartySeqNo(storeOrderAssetInward.getRequestedToPartySeqNo());
		storeOrderAssetInward_DTO.setRequestorSeqNo(storeOrderAssetInward.getRequestorSeqNo());
		storeOrderAssetInward_DTO.setAssetSeqNo(storeOrderAssetInward.getAssetSeqNo());
		storeOrderAssetInward_DTO.setStoreRequestSeqNo(storeOrderAssetInward.getStoreRequestSeqNo());
		return storeOrderAssetInward_DTO;
	}

}