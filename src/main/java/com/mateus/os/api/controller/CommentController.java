package com.mateus.os.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mateus.os.api.model.Comment;
import com.mateus.os.api.model.CommentInput;
import com.mateus.os.api.model.CommentModel;
import com.mateus.os.domain.exception.EntityNotFoundException;
import com.mateus.os.domain.model.ServiceOrder;
import com.mateus.os.domain.repository.ServiceOrderRepository;
import com.mateus.os.domain.service.CrudServiceOrderService;

@RestController
@RequestMapping("/serviceorders/{serviceOrderId}/comments")
public class CommentController {

	@Autowired
	private CrudServiceOrderService crudServiceOrder;

	@Autowired
	private ServiceOrderRepository soRepository;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping
	public List<CommentModel> list(@PathVariable Long serviceOrderId) {
		ServiceOrder serviceOrder = soRepository.findById(serviceOrderId)
				.orElseThrow(() -> new EntityNotFoundException("Service Order not found"));

		return toCollectionModel(serviceOrder.getComments());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CommentModel add(@PathVariable Long serviceOrderId, @Valid @RequestBody CommentInput comenInput) {
		Comment comment = crudServiceOrder.addComment(serviceOrderId, comenInput.getDescription());

		return toModel(comment);
	}

	private CommentModel toModel(Comment comment) {
		return modelMapper.map(comment, CommentModel.class);
	}

	private List<CommentModel> toCollectionModel(List<Comment> comments) {
		return comments.stream().map(comment -> toModel(comment)).collect(Collectors.toList());
	}
}
