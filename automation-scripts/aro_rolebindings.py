import json
import pandas as pd

# Load rolebindings (namespaced)
with open("rolebindings.json") as f:
    rolebindings = json.load(f)

# Load clusterrolebindings
with open("clusterrolebindings.json") as f:
    clusterrolebindings = json.load(f)

rows = []

# Parse namespaced role bindings
for item in rolebindings.get("items", []):
    ns = item["metadata"].get("namespace", "")
    role_ref = item["roleRef"]["name"]
    kind = item["roleRef"]["kind"]
    for subject in item.get("subjects", []):
        rows.append({
            "Namespace": ns,
            "Binding Type": "RoleBinding",
            "Subject Name": subject.get("name"),
            "Subject Kind": subject.get("kind"),
            "Role": role_ref,
            "Role Kind": kind
        })

# Parse cluster role bindings
for item in clusterrolebindings.get("items", []):
    role_ref = item["roleRef"]["name"]
    kind = item["roleRef"]["kind"]
    for subject in item.get("subjects", []):
        rows.append({
            "Namespace": "cluster-wide",
            "Binding Type": "ClusterRoleBinding",
            "Subject Name": subject.get("name"),
            "Subject Kind": subject.get("kind"),
            "Role": role_ref,
            "Role Kind": kind
        })

# Create DataFrame and export
df = pd.DataFrame(rows)
df.to_excel("oc_user_role_bindings.xlsx", index=False)
print("Exported to oc_user_role_bindings.xlsx")
