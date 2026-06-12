package com.pb.tcs.boot.web;

import com.pb.tcs.api.ParityApi;
import com.pb.tcs.harness.LegacyTradeExtract;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/parity")
class ParityRestController {

    private final ParityApi parityApi;

    ParityRestController(ParityApi parityApi) {
        this.parityApi = parityApi;
    }

    @PostMapping("/runs")
    ParityApi.ParityRunResponse run(@RequestBody ParityRunBody body) {
        return parityApi.run(new ParityApi.ParityRunRequest(body.extracts()));
    }

    record ParityRunBody(List<LegacyTradeExtract> extracts) {}
}
