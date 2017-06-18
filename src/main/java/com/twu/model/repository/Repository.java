package com.twu.model.repository;

import com.twu.model.artifacts.Artifact;

import java.util.List;

public interface Repository {
    List<Artifact> getAvailableArtifacts();

    boolean checkoutArtifact(String title);

    boolean returnArtifact(String title);
}
