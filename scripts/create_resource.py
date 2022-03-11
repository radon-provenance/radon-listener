#!/home/radon/ve/radon-lib/bin/python

import sys
import json

from radon.model import Resource
from radon.database import (
    connect,
    initialise
)


if (len(sys.argv) != 2):
    sys.exit(-1)

# Get the path of the resource in Radon as a parameter
resc_path = sys.argv[1]

initialise()
connect()

r = Resource.find(resc_path)

# Read the content of the Json file
data = ""
for chunk in r.chunk_content():
    data += chunk.decode()

data_json = json.loads(data)

old_meta = r.get_cdmi_user_meta()

# Add user metadata to the existing metadata

if "inputs" in data_json:
    for key in data_json["inputs"]:
        old_meta[key] = data_json["inputs"].get(key, "")

r.update(user_meta=old_meta)

