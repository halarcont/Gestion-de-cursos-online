package com.onlinecourse.requestservice.controller;

import com.onlinecourse.requestservice.client.CourseClientFeign;
import com.onlinecourse.requestservice.entity.RequestEntity;
import com.onlinecourse.requestservice.enums.State;
import com.onlinecourse.requestservice.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/request")
public class RequestController {

    @Autowired
    private CourseClientFeign courseClientFeign;

    @Autowired
    private RequestService requestService;

    /**
     * metodo que se encarga de crear una solicitud para crear curso
     * @param requestEntity
     * @return response status CREATED
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RequestEntity createRequest(@RequestBody RequestEntity requestEntity){
        return requestService.createRequest(requestEntity);
    }

    /**
     * se encarga de modificar una solicitud de acuerdo al id proporcionado
     * @param requestEntity
     * @param id
     * @return response status OK
     */
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RequestEntity updateRequest(@RequestBody RequestEntity requestEntity, @PathVariable Long id) {
        return requestService.updateRequest(requestEntity, id);
    }

    /**
     * metodo para aporbar una solicitud
     * @param requestEntity
     * @param id
     * @return response status OK
     */
    @PutMapping("/approbe/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RequestEntity approbeRequest(@RequestBody RequestEntity requestEntity, @PathVariable Long id) {
        requestEntity.getCourseData().setCourseState(State.Approved);
        return requestService.updateRequest(requestEntity, id);
    }

    /**
     * metodo para rechazar una solicitud
     * @param requestEntity
     * @param id
     * @return response status OK
     */
    @PutMapping("/rejerct/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RequestEntity rejectRequest(@RequestBody RequestEntity requestEntity, @PathVariable Long id) {
        requestEntity.getCourseData().setCourseState(State.Rejected);
        return requestService.updateRequest(requestEntity, id);
    }

    /**
     * borrar una solicitud
     * @param id
     */
    @DeleteMapping("/{id}")
    public void deleteRequest( @PathVariable Long id) {
        requestService.deleteRequest(id);

    }

    /**
     * listar las solicitudes
     * @return
     */
    @GetMapping
    public Iterable<RequestEntity> list() {
        return requestService.list();
    }

    /**
     * muestra la solicitud con el id proporcionado
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public RequestEntity findById(@PathVariable Long id) {
        return requestService.findById(id);
    }
}
