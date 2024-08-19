package com.ait.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ait.tx.entity.AuditLog;
import com.ait.tx.repository.AuditLogRepository;

@Service
public class AuditService {
	@Autowired
    private AuditLogRepository auditLogRepository;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void saveAuditLog(AuditLog log) {
		auditLogRepository.save(log);
	}

}
