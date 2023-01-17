package com.example.boilerplateproj.domain.vue.board.controller;

import com.example.boilerplateproj.domain.vue.board.controller.request.VueBoardRequest;
import com.example.boilerplateproj.domain.vue.board.entity.VueBoard;
import com.example.boilerplateproj.domain.vue.board.service.VueBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
// Controller와 RestController의 가장 큰 차이점은 무엇인가 ?
// 웹/앱 상의 모든 데이터는 무엇으로 전달 될까요 ? json
// 실제로 Controller는 HTML 이나 JSP 같은 페이지를 제어하는 목적으로 사용합니다.
// 그러나 근래 MSA 환경이나 Frontend 엔진이 별개로 분리되는 상황에서는
// 실제 서로 각기 다른 서비스들에 json 형태로 데이터만 전달해주면 됩니다.
// 이와 같은 이유로 Vue와 Spring이 통신할 때는 RestController가 사용된 것을 볼 수 있습니다.
// 왜냐하면 @ResponseBody 같은 키워드를 별도로 붙여줄 필요 없이
// 알아서 json 타입으로 결과를 변환해서 보내주기 때문입니다.
@RequestMapping("39th/jpa/board")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
//@CrossOrigin(origins = "http://localhost:8081", allowedHeaders = "*")
public class VueBoardController {

    @Autowired
    private VueBoardService service;

    // 위와 같이 RequestMapping을 Controller 전역에 걸게 되면
    // 아래의 어떤 Mapping을 사용하던 39th/jpa/board 형태의 URL이 앞에 붙음을 의미합니다.
    @GetMapping("/list")
    public List<VueBoard> boardList () {
        log.info("boardList()");

        return service.list();
    }

    @PostMapping("/register")
    public void boardRegister (@RequestBody VueBoardRequest boardRequest) {
        log.info("boardRegister()");

        service.register(boardRequest);
    }

    @GetMapping("/{boardNo}")
    public VueBoard boardRead (@PathVariable("boardNo") Long boardNo) {
        log.info("boardRead()");

        return service.read(boardNo);
    }

    // 가변 인자를 사용한 URL Mapping은 아래와 같이
    // {가변인자} 형태로 작성합니다.
    @DeleteMapping("/{boardNo}")
    public void boardRemove (@PathVariable("boardNo") Long boardNo) {
        // @PathVariable은 가변 인자를 처리하기 위해 사용하는 키워드입니다.
        // 게시물 번호는 1 ~ N 번까지 다양하기 때문에
        // 특정 번호에 대한 URL Mapping을 하면
        // 매우 매우 번거롭고 코드가 깔끔하지 못하고 지저분 해집니다.
        // 그러므로 이와 같은 가변 인자 처리를 통해 boardNo를 일관된 방식으로 관리합니다.
        log.info("boardRemove()");

        service.remove(boardNo);
    }

    @PutMapping("/{boardNo}")
    public VueBoard boardModify (@PathVariable("boardNo") Long boardNo,
                                 @RequestBody VueBoardRequest boardRequest) {
        log.info("boardModify()");

        return service.modify(boardNo, boardRequest);
    }
}
