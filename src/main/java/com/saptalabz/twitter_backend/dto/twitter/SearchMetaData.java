package com.saptalabz.twitter_backend.dto.twitter;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
public class SearchMetaData {

    public double completed_in;
    public long max_id;
    public String max_id_str;
    public String next_results;
    public String query;
    public String refresh_url;
    public int   count;
    public int since_id;
    public String since_id_str;

    public SearchMetaData(double completed_in, long max_id, String max_id_str, String next_results, String query, String refresh_url, int count, int since_id, String since_id_str) {
        this.completed_in = completed_in;
        this.max_id = max_id;
        this.max_id_str = max_id_str;
        this.next_results = next_results;
        this.query = query;
        this.refresh_url = refresh_url;
        this.count = count;
        this.since_id = since_id;
        this.since_id_str = since_id_str;
    }
}
