import java.util.HashMap;

public class AssetStore {

    private HashMap<String, Asset> assets = new HashMap<>();

    public void addAsset(Asset asset) {
        assets.put(asset.assetId, asset);
    }

    public Asset findAsset(String assetId) {
        Asset a = assets.get(assetId);
        if (a == null) {
            throw new NullPointerException("Asset not found: " + assetId);
        }
        return a;
    }

    public void markBorrowed(Asset a) {
        if (!a.available) {
            throw new IllegalStateException("Asset already borrowed.");
        }
        a.available = false;
    }
}