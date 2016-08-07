package io.toru.imagesearching.model;

/**
 * Created by toru on 2016. 8. 7..
 */
public class OriginalSearchingResultModel {
    private ChannelResultModel channel = new ChannelResultModel();

    public ChannelResultModel getChannel() {
        return channel;
    }

    public void setChannel(ChannelResultModel channel) {
        this.channel = channel;
    }
}
