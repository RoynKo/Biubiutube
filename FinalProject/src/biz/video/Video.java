package biz.video;

import biz.account.Account;

import java.util.HashSet;

public class Video {
    private Account uploader;
    private VideoAdType adType;
    private VideoStatus status;
    private VoteCatalog voteCatalog;
    private CommentCatalog commentCatalog;
    private ViewHistoryCatalog viewHistoryCatalog;
    private String title;
    private HashSet<VideoTag> tagHashSet;

    public enum VideoAdType {
        NoAdd("No Advertisement"),
        AnyAdd("Any Advertisement"),
        CommOnly("Commercial Advertisements Only"),
        PSAOnly("PSAs Only");

        VideoAdType(String value) {
            this.value = value;
        }

        private String value;

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public enum VideoStatus {
        Uploaded("Uploaded", "Video uploaded, waiting department supervisor to approve."),
        DSApproved("Department Supervisor Approved", "Video is approved by department supervisor, waiting enterprise supervisor to approve."),
        ESApproved("Enterprise Supervisor Approved", "Video is approved by enterprise supervisor, it can be viewed"),
        Banned("Banned", "Video is banned according to censorship");

        String title;
        String description;
        VideoStatus(String title, String description) {
            this.title = title;
            this.description = description;
        }

        @Override
        public String toString() {
            return this.title;
        }

        public String getDescription() {
            return description;
        }

        public String getTitle() {
            return title;
        }
    }

    public VideoAdType getAdType() {
        return adType;
    }

    public Account getUploader() {
        return uploader;
    }

    public void setAdType(VideoAdType adType) {
        this.adType = adType;
    }

    public VoteCatalog getVoteCatalog() {
        return voteCatalog;
    }

    public CommentCatalog getCommentCatalog() {
        return commentCatalog;
    }

    public ViewHistoryCatalog getViewHistoryCatalog() {
        return viewHistoryCatalog;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean canView() {
        return this.status.equals(VideoStatus.ESApproved);
    }

    public void addTag(VideoTag tag) {
        this.tagHashSet.add(tag);
    }

    public void removeTag(VideoTag tag) {
        this.tagHashSet.remove(tag);
    }

    public HashSet<VideoTag> getTagHashSet() {
        return tagHashSet;
    }

    Video(Account uploader) {
        this.uploader = uploader;
        this.voteCatalog = new VoteCatalog(this);
        this.commentCatalog = new CommentCatalog(this);
        this.viewHistoryCatalog = new ViewHistoryCatalog(this);
        this.tagHashSet = new HashSet<>();
        this.adType = VideoAdType.NoAdd;  // default no ad
        this.status = VideoStatus.Uploaded;
        this.title = "";
    }

    @Override
    public String toString() {
        return title;
    }
}