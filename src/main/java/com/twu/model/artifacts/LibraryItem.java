package com.twu.model.artifacts;

public class LibraryItem {

    private final Artifact artifact;
    private final ItemType type;

    public LibraryItem(Artifact artifact, ItemType type) {
        this.artifact = artifact;
        this.type = type;
    }

    public ItemType getType() {
        return type;
    }

    public String getTitle() {
        return artifact.getTitle();
    }

    public Artifact getArtifact() {
        return artifact;
    }
}
