package com.yooinkeun.webservice.service.member;

import com.yooinkeun.webservice.domain.Team.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
}
