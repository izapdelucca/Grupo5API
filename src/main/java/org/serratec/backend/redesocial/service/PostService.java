package org.serratec.backend.redesocial.service;

import org.serratec.backend.redesocial.exception.NotFoundException;
import org.serratec.backend.redesocial.model.Post;
import org.serratec.backend.redesocial.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<Post> findAll() {
        return postRepository.findAll();
    }
    
    // Instancia para suportar paginacao
    public Page<Post> findAll(Pageable pageable) {
        return postRepository.findAll(pageable);
    }


    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }
    
    //metodo para listar post por idade usando uma native query | TESTAR |
    public Page<Object[]> listarPostPorIdade(int idade, Pageable pageable){
    	 Page<Object[]> posts = postRepository.listarPostPorIdade(idade, pageable);
    	 if(posts.isEmpty()) {
    		 throw new NotFoundException("Nenhum post encontrado para a idade informada: " +idade);
    	 }
    	 return posts;
    }
    
    public Post update(Post post) {
    	return postRepository.save(post);
    }

    
}
