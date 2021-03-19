package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Agent;
import com.lambdaschool.orders.repositories.AgentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "agentsService")
public class AgentServiceImpl implements AgentsService {

    @Autowired
    private AgentsRepository agentsrepos;

    @Override
    public Agent findAgentById(long agentid) throws EntityNotFoundException {
        return agentsrepos.findById(agentid).orElseThrow(()-> new EntityNotFoundException("Agent Id "+agentid + " Not found"));
    }
}
