package com.kafka.springboot.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "wikimedia_recent_changes")
public class WikimediaData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String wikiEventData;
}
