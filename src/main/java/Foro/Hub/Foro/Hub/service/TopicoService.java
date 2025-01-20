package Foro.Hub.Foro.Hub.service;



import com.forohub.model.Topico;
import com.forohub.repository.TopicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    private final TopicoRepository repository;

    public TopicoService(TopicoRepository repository) {
        this.repository = repository;
    }

    public List<Topico> listarTodos() {
        return repository.findAll();
    }

    public Topico obtenerPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Tópico no encontrado"));
    }

    public Topico crear(Topico topico) {
        return repository.save(topico);
    }

    public Topico actualizar(Long id, Topico datos) {
        Topico topico = obtenerPorId(id);
        topico.setTitulo(datos.getTitulo());
        topico.setMensaje(datos.getMensaje());
        topico.setAutor(datos.getAutor());
        return repository.save(topico);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
