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

@Service("jobConsignmentMasterCUDServ")
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
			ConsignmentMaster_DTO jobConsignmentMaster_DTO) {
		CompletableFuture<ConsignmentMaster_DTO> future = CompletableFuture.supplyAsync(() -> 
		{
			ConsignmentMaster_DTO jcmDTO = null;
			if (!consignmentMasterCUDRepo.existsById(jobConsignmentMaster_DTO.getConsignmentSeqNo())) 
			{
				jcmDTO = this.getConsignmentMaster_DTO(
						consignmentMasterCUDRepo.save(this.setConsignmentMaster_DTO(jobConsignmentMaster_DTO)));
				}
			return jcmDTO;
		}, asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<Void> updConsignmentMaster(ConsignmentMaster_DTO jobConsignmentMaster_DTO) {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			
			if (consignmentMasterCUDRepo.existsById(jobConsignmentMaster_DTO.getConsignmentSeqNo())) 
			{
				consignmentMasterCUDRepo.save(this.setConsignmentMaster_DTO(jobConsignmentMaster_DTO));
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
	public CompletableFuture<Void> delSelectConsignmentMastersByRequests(CopyOnWriteArrayList<Long> pids) {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			consignmentMasterCUDRepo.delSelectConsignmentMastersByRequests(pids);
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
			CopyOnWriteArrayList<ConsignmentMaster> jobMasters) {
		ConsignmentMaster_DTO jobDTO = null;
		CopyOnWriteArrayList<ConsignmentMaster_DTO> jobDTOs = new CopyOnWriteArrayList<ConsignmentMaster_DTO>();

		for (int i = 0; i < jobMasters.size(); i++) {
			jobDTO = getConsignmentMaster_DTO(jobMasters.get(i));
			jobDTOs.add(jobDTO);
		}
		return jobDTOs;
	}

	private synchronized ConsignmentMaster_DTO getConsignmentMaster_DTO(ConsignmentMaster jobMaster2) {
		ConsignmentMaster_DTO jobMasterDTO = new ConsignmentMaster_DTO();
		jobMasterDTO = new ConsignmentMaster_DTO();
		jobMasterDTO.setConsignmentSeqNo(jobMaster2.getConsignmentSeqNo());
		jobMasterDTO.setFromLocationSeqNo(jobMaster2.getFromLocationSeqNo());
		jobMasterDTO.setFromPartySeqNo(jobMaster2.getFromPartySeqNo());
		jobMasterDTO.setParConsignmentSeqNo(jobMaster2.getParConsignmentSeqNo());
		jobMasterDTO.setStoreRequestSeqNo(jobMaster2.getStoreRequestSeqNo());
		jobMasterDTO.setToLocationSeqNo(jobMaster2.getToLocationSeqNo());
		jobMasterDTO.setToPartySeqNo(jobMaster2.getToPartySeqNo());
		jobMasterDTO.setRemark(jobMaster2.getRemark());
		jobMasterDTO.setStatus(jobMaster2.getStatus());
		return jobMasterDTO;
	}

	private synchronized ConsignmentMaster setConsignmentMaster_DTO(ConsignmentMaster_DTO jobMasterDTO) {
		ConsignmentMaster jobMaster = new ConsignmentMaster();
		jobMaster.setFromLocationSeqNo(jobMasterDTO.getFromLocationSeqNo());
		jobMaster.setFromPartySeqNo(jobMasterDTO.getFromPartySeqNo());
		jobMaster.setParConsignmentSeqNo(jobMasterDTO.getParConsignmentSeqNo());
		jobMaster.setStoreRequestSeqNo(jobMasterDTO.getStoreRequestSeqNo());
		jobMaster.setToLocationSeqNo(jobMasterDTO.getToLocationSeqNo());
		jobMaster.setToPartySeqNo(jobMasterDTO.getToPartySeqNo());
		jobMaster.setRemark(jobMasterDTO.getRemark());
		jobMaster.setStatus(jobMasterDTO.getStatus());
		return jobMaster;
	}

}