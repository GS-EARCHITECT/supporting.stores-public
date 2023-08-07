package consignment_master_mgmt.services.cud;

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
import consignment_master_mgmt.model.dto.ConsignmentMaster_DTO;
import consignment_master_mgmt.model.master.ConsignmentMaster;
import consignment_master_mgmt.model.repo.cud.ConsignmentMasterCUD_Repo;

@Service("conConsignmentMasterCUDServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ConsignmentMasterCUD_Service implements I_ConsignmentMasterCUD_Service {

	// private static final Logger logger =
	// LoggerFactory.getLogger(ConsignmentMasterService.class);

	@Autowired
	private ConsignmentMasterCUD_Repo consignmentMasterCUDRepo;

	@Autowired
	private Executor asyncExecutor;

	@Override
	public CompletableFuture<ConsignmentMaster_DTO> newConsignmentMaster(
			ConsignmentMaster_DTO conConsignmentMaster_DTO) {
		CompletableFuture<ConsignmentMaster_DTO> future = CompletableFuture.supplyAsync(() -> 
		{
			ConsignmentMaster_DTO jcmDTO = null;
			if (!consignmentMasterCUDRepo.existsById(conConsignmentMaster_DTO.getConsignmentSeqNo())) 
			{
				jcmDTO = this.getConsignmentMaster_DTO(
						consignmentMasterCUDRepo.save(this.setConsignmentMaster_DTO(conConsignmentMaster_DTO)));
				}
			return jcmDTO;
		}, asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<Void> updConsignmentMaster(ConsignmentMaster_DTO conConsignmentMaster_DTO) {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			
			if (consignmentMasterCUDRepo.existsById(conConsignmentMaster_DTO.getConsignmentSeqNo())) 
			{
				consignmentMasterCUDRepo.save(this.setConsignmentMaster_DTO(conConsignmentMaster_DTO));
			}
			return;
		}, asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<Void> delSelectConsignmentMasters(CopyOnWriteArrayList<Long> jcmSeqNos) {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			consignmentMasterCUDRepo.delSelectConsignmentMasters(jcmSeqNos);
			return;
		}, asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<Void> delSelectConsignmentMastersByParents(CopyOnWriteArrayList<Long> pids) {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			consignmentMasterCUDRepo.delSelectConsignmentMastersByParents(pids);
			return;
		}, asyncExecutor);

		return future;
	}

	@Override
	public CompletableFuture<Void> delSelectConsignmentMastersForParties(CopyOnWriteArrayList<Long> pids) {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			consignmentMasterCUDRepo.delSelectConsignmentMastersForParties(pids);
			return;
		}, asyncExecutor);

		return future;
	}

	@Override
	public CompletableFuture<Void> delSelectConsignmentMastersToParties(CopyOnWriteArrayList<Long> pids) {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			consignmentMasterCUDRepo.delSelectConsignmentMastersToParties(pids);
			return;
		}, asyncExecutor);

		return future;
	}

	@Override
	public CompletableFuture<Void> delAllConsignmentMasters() {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			consignmentMasterCUDRepo.deleteAll();
			return;
		}, asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<Void> updConsignmentMasterDone(Long id)
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			consignmentMasterCUDRepo.updConsignmentMasterDone(id);
			return;
		}, asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<Void> updConsignmentMasterDoneStatus(Long scid, Character st)
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			consignmentMasterCUDRepo.updConsignmentMasterDoneStatus(scid, st);
			return;
		}, asyncExecutor);
		return future;
	}
	
	@Override
	public CompletableFuture<Void> updConsignmentMasterOk(Long id)
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			consignmentMasterCUDRepo.updConsignmentMasterOk(id);
			return;
		}, asyncExecutor);
		return future;
	}
	
	@Override
	public CompletableFuture<Void> updConsignmentMasterOkStatus(Long scid, Character st)
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			consignmentMasterCUDRepo.updConsignmentMasterOkStatus(scid, st);
			return;
		}, asyncExecutor);
		return future;
	}
	
	private synchronized CopyOnWriteArrayList<ConsignmentMaster_DTO> getConsignmentMaster_DTOs(
			CopyOnWriteArrayList<ConsignmentMaster> conMasters) {
		ConsignmentMaster_DTO conDTO = null;
		CopyOnWriteArrayList<ConsignmentMaster_DTO> conDTOs = new CopyOnWriteArrayList<ConsignmentMaster_DTO>();

		for (int i = 0; i < conMasters.size(); i++) {
			conDTO = getConsignmentMaster_DTO(conMasters.get(i));
			conDTOs.add(conDTO);
		}
		return conDTOs;
	}

	private synchronized ConsignmentMaster_DTO getConsignmentMaster_DTO(ConsignmentMaster conMaster2) {
		ConsignmentMaster_DTO conMasterDTO = new ConsignmentMaster_DTO();
		conMasterDTO = new ConsignmentMaster_DTO();
		conMasterDTO.setConsignmentSeqNo(conMaster2.getConsignmentSeqNo());
		conMasterDTO.setFromLocationSeqNo(conMaster2.getFromLocationSeqNo());
		conMasterDTO.setFromPartySeqNo(conMaster2.getFromPartySeqNo());
		conMasterDTO.setParConsignmentSeqNo(conMaster2.getParConsignmentSeqNo());
		conMasterDTO.setToLocationSeqNo(conMaster2.getToLocationSeqNo());
		conMasterDTO.setToPartySeqNo(conMaster2.getToPartySeqNo());
		conMasterDTO.setRemark(conMaster2.getRemark());
		return conMasterDTO;
	}

	private synchronized ConsignmentMaster setConsignmentMaster_DTO(ConsignmentMaster_DTO conMasterDTO) {
		ConsignmentMaster conMaster = new ConsignmentMaster();
		conMaster.setFromLocationSeqNo(conMasterDTO.getFromLocationSeqNo());
		conMaster.setFromPartySeqNo(conMasterDTO.getFromPartySeqNo());
		conMaster.setParConsignmentSeqNo(conMasterDTO.getParConsignmentSeqNo());
		conMaster.setToLocationSeqNo(conMasterDTO.getToLocationSeqNo());
		conMaster.setToPartySeqNo(conMasterDTO.getToPartySeqNo());
		conMaster.setRemark(conMasterDTO.getRemark());		
		return conMaster;
	}

}