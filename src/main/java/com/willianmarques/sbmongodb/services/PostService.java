package com.willianmarques.sbmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.willianmarques.sbmongodb.domain.Post;
import com.willianmarques.sbmongodb.repositories.PostRepository;
import com.willianmarques.sbmongodb.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	public Post findById( String id) {
		Optional<Post> post = postRepository.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado."));
	}
	
	public List<Post> findByTitle(String text) {
		return postRepository.searchTitle(text);
	}
	
}
