package com.batch.example.demo.batch.reader;

import com.batch.example.demo.model.PersonDto;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class CSVReader {

    public FlatFileItemReader<PersonDto> reader() {
        FlatFileItemReader<PersonDto> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource("persons.csv"));
        reader.setLinesToSkip(1); // Saltamos la cabecera del CSV

        DefaultLineMapper<PersonDto> lineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();

        tokenizer.setNames("nombre", "apellido", "edad", "dni");
        tokenizer.setDelimiter(",");

        BeanWrapperFieldSetMapper<PersonDto> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(PersonDto.class);

        lineMapper.setLineTokenizer(tokenizer);
        lineMapper.setFieldSetMapper((fieldSet) -> {
            return new PersonDto(
                fieldSet.readString("nombre"),
                fieldSet.readString("apellido"),
                fieldSet.readInt("edad"),
                fieldSet.readString("dni"),
                null // El salary no está en el CSV, lo dejamos como null
            );
        });

        reader.setLineMapper(lineMapper);
        return reader;
    }
}
