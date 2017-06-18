package com.twu.model.repository;

import com.twu.model.artifacts.Artifact;
import com.twu.model.menuoption.MenuOption;
import com.twu.model.provider.MenuOptionProvider;

import java.util.List;

public interface Repository {
    List<Artifact> getAvailableArtifacts();

    boolean checkoutArtifact(String title);

    boolean returnArtifact(String title);
}
