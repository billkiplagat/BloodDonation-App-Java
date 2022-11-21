package com.billy.message;

import com.billy.donor.DonorEntity;
import com.billy.hospital.Hospital;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Message {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "message_id")
    private Long id;
    private String message;
    private boolean opened = false;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "donor_id",
            referencedColumnName = "donor_id"
    )
    private DonorEntity donor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "hospital_id",
            referencedColumnName = "hospital_id"
    )
    private Hospital hospital;




}
