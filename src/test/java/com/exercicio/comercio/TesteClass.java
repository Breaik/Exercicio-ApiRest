package com.exercicio.comercio;

import com.exercicio.comercio.Entity.Comerce;
import com.exercicio.comercio.Repository.CommerceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class) // esta anotação faz a intermediação do spring boot e do junit
public class TesteClass {

    @Autowired
    CommerceRepository commerceRepository;

    @Test
    public void comercE(){
    }
}
