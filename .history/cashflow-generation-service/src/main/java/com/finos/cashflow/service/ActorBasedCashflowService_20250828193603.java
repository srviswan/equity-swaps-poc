package com.finos.cashflow.service;

import com.finos.cashflow.actor.ActorSystem;
import com.finos.cashflow.actor.CashflowGenerationActor;
import com.finos.cashflow.actor.CashflowGenerationActorState;
import com.finos.cashflow.model.Cashflow;
import com.finos.cashflow.model.CashflowGenerationRequest;
import com.finos.cashflow.model.CashflowGenerationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
