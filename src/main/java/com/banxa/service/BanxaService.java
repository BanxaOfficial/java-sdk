package com.banxa.service;

import com.banxa.model.request.*;
import com.banxa.model.response.*;

public interface BanxaService {
    <T> BanxaResponse<T> request(Request<T> request);
}
