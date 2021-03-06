package com.arrayteam.argo.server.dao.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@Table(name = "VirtualContents")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class VirtualContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "Virtual content's unique id", example = "7")
    private Long id;

    @ApiModelProperty(value = "Virtual content's type")
    private Type.VirtualContentType type;

    @CreationTimestamp
    @ApiModelProperty(value = "Create date")
    private Date createdAt;

    @UpdateTimestamp
    @ApiModelProperty(value = "Update date")
    private Date updatedAt;

    @OneToMany(mappedBy = "virtualContent", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<VirtualContent3D> virtualContent3DS = new ArrayList<>();

}
